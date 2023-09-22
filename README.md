# 專案介紹
本專案使用Spring Boot 搭配Spring security與JWT機制作驗證，
使用H2資料庫，加上Swagger3 功能。 

## 資料
資料庫table的create script和data的insert script 位置在 src/main/resources，
可不用手動執行，Spring Boot啟動時會自動執行script

# 步驟一
## maven
`run maven install`

## Spring
  SpringBootApplication start

## Swagger URl
http://localhost:8888/swagger-ui/index.html



# API Documentation

## Introduction

建議使用postman，
專案中主要的API介紹，使用順序 可先使用註冊API，或是可以使用以下範例登入，再回傳的Header中取得Token

```
{
"account": "55688",
"password": "123"
}
```

### Token Header

在對商品進行操作時都要帶入 `Authorization` : `bearer Token` 於Header，才能與API溝通

Authorization: Bearer YOUR_ACCESS_TOKEN

替換 `YOUR_ACCESS_TOKEN` 為登入後取得的Token

## Endpoints

### POST /api/v1/user

註冊使用者，回傳使用者資訊

#### Request

- Method: POST
- URL: `http://localhost:8888/api/v1/user`
- Request Body:
  ```json
  {
    "account": "bbq93",
    "password": "123",
    "name": "KAO"
  }
  ```

#### Response

- HTTP Status Code: 200 OK
- Response Body:
    ```json
    {
      "success": true
    }
    ```

### POST /auth/login

登入 取得Token

#### Request

- Method: POST
- URL: `http://localhost:8888/auth/login
- Request Body:
  ```json
  {
    "account": "bbq93",
    "password": "123"
  }
  ```

#### Response

- HTTP Status Code: 200 OK
- Response Body:
    ```
      "Response with header"
    ```
- Response Headers
  ```
  {
    Authorization:  ACCESS_TOKEN
  }
  ```

### GET /api/v1/goods

取得所有商品資訊。

#### Request
- Method: GET
- URL: `http://localhost:8888/api/v1/goods`
- Headers:
  - Authorization: Bearer YOUR_ACCESS_TOKEN

#### Response
- HTTP Status Code: 200 OK
- Response Body:
    ```json
   [
    {
        "id": 2,
        "name": "IPhone 15"
    }
  ]
    ```

### POST /api/v1/goods/add

新增商品資訊。

#### Request
- Method: POST
- URL: `http://localhost:8888/api/v1/goods/add`
- Headers:
  - Authorization: Bearer YOUR_ACCESS_TOKEN
- Request Body:
  ```json
  {
    "name":"IPhone 15"
  }
  ```

#### Response
- HTTP Status Code: 200 OK
- Response Body:
    ```json
  {
      "id": 2,
      "name": "IPhone 15"
  }
    ```

### PUT /api/v1/goods/{1}

更新商品資訊。

#### Request
- Method: PUT
- URL: `http://localhost:8888/api/v1/goods/2`
- Headers:
  - Authorization: Bearer YOUR_ACCESS_TOKEN
- Request Body:
  ```json
  {
    "name":"IPhone 16"
  }
  ```

#### Response
- HTTP Status Code: 200 OK
- Response Body:
    ```json
  {
      "id": 2,
      "name": "IPhone 16"
  }
    ```

### DELETE /api/v1/goods/{1}

刪除商品資訊。

#### Request
- Method: DELETE
- URL: `http://localhost:8888/api/v1/goods/1`
- Headers:
  - Authorization: Bearer YOUR_ACCESS_TOKEN

#### Response
- HTTP Status Code: 200 OK
- Response Body:
    ```json
  {
     "success": true
  }
    ```
