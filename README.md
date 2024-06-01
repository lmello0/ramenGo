# RamenGo

Repository containing the code for a ramen order system backend,
it allows users to order ramens online,
based on the choice of a **broth** and a **protein**.

## Technologies

The project is built using:
- Java 17
- Spring Boot 3
- PostgreSQL
- Docker

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/lmello0/ramenGo.git
    cd ramenGo
    ```

2. Setup environment variables:

    You should copy the `.env.example` (`cp .env.example .env`)
    and fill each field with a value.
   
3. Run with `docker compose`:

   If you run with `docker compose`, a container with the spring backend and a
   postgres instance will be created.

   ```bash
   docker compose up --build
   ```
   
## Usage

First, you will need to access database and insert on table `users`:

```sql
INSERT INTO users (id, api_key, name)
VALUES (uuid_generate_v4(), '<key>', '<name>');
```

Now you will be able to make requests to the system. 
The API accept the following requests:

| HTTP Verb | Endpoint  |
|-----------|-----------|
| GET       | /broths   |
| GET       | /proteins |
| POST      | /order    |

You must add header `X-API-KEY` with the value inserted on database for each request.

### Requests:

#### **GET `/broths`**:
```http request
Returns a list of broths:

[
   {
      id: "1",
      imageInactive: "https://<image_url>",
      imageActive: "https://<image_url>",
      name: "Salt",
      description: "Simple like the seawater, nothing more",
      price: 10.00
   }
]
```

#### **GET `/proteins`**:
```http request
Returns a list of proteins:

[
   {
      id: "1",
      imageInactive: "https://<image_url>",
      imageActive: "https://<image_url>",
      name: "Chasu",
      description: "A sliced flavourful pork meat with a selection of season vegetables",
      price: 10.00
   }
]
```

#### **POST `/order`**:

```http request
POST /order
Content-Type: application/json or text/plain

{
    "brothId": 1,
    "proteinId": 1
}

=== 

{
    id: 1,
    description: "Salt and Chasu Ramen",
    image: "https://<image_url>"
}
```