Конечно! Вот перевод нужных разделов на русский язык:

---

# 🚀 Docker Code Executor API

Лёгкий REST API на базе Flask, позволяющий загружать и выполнять Python-скрипты в Docker-контейнерах. Каждое выполнение изолировано, с ограничениями по ресурсам и управлением сессиями для обеспечения безопасности и производительности.

---

## 📦 Возможности

- 🔐 Запуск кода в изолированных Docker-контейнерах  
- 🧼 Очистка и предразогрев сессий  
- 🧪 Получение результатов выполнения и логов  
- 🔁 Поддержка Docker Compose для удобного запуска  
- 🧾 Документация Swagger (OpenAPI) включена  

---

## 📁 Структура проекта

```
CYBERSECURITYPLATFORM/
├── platform_backend_python/
    ├── docker-compose.yml
    └── app/
        └── development_env/
            ├── web_platform_executor.py
            ├── swagger.yml
            └── Dockerfile
```

---

## 🚀 Быстрый старт

### 1. Сборка и запуск

Убедитесь, что Docker установлен, затем выполните:

```bash
docker-compose up --build
```

API будет доступен по адресу: [http://localhost:5000](http://localhost:5000)

### 2. Swagger-документация

Интерактивная документация API:  
👉 [http://localhost:5000/apidocs](http://localhost:5000/apidocs)

---

## 📌 API Эндпоинты

### 🔸 `POST /execute`  
Загрузка и выполнение Python-скрипта в Docker-контейнере.

**Запрос:** `multipart/form-data`

- `file`: Python-скрипт (например, `main.py`)

**Ответ:**
```json
{
  "session_id": "abc-123-xyz"
}
```

---

### 🔸 `GET /result/{session_id}`  
Получение логов выполнения по ID сессии.

**Если выполнение завершено:**
```json
{
  "logs": "Hello from Python\n"
}
```

**Если всё ещё выполняется:**
```json
{
  "status": "still running"
}
```

---

### 🔸 `POST /cleanup/{session_id}`  
Остановка и удаление работающего контейнера.

**Ответ:**
```json
{
  "status": "cleaned up"
}
```

---

### 🔸 `POST /prewarm`  
Ручной запуск предразогрева контейнеров.

**Ответ:**
```json
{
  "status": "prewarm triggered"
}
```

---

## 🛠 Стек технологий

- **Python 3.9**
- **Flask + Flasgger**
- **Docker SDK for Python**
- **Docker Compose**

---

## ⚠️ Примечания

- Поддерживаются только Python-скрипты (`.py`)
- Код выполняется с ограничениями по памяти и CPU
- Docker socket (`/var/run/docker.sock`) должен быть проброшен в контейнер

---
