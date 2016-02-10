# Database Design

### Tables

#### User

| Columns | Type |
-------------------
| Id | Int (Auto Increment) (PK)|
| Username | String |
| Email | String |
| Password | String |
--------------------

#### Kata

| Column | Type |
------------------
| Id | Int (Auto Increment) (PK) |
| Name | String |
| Description | String |
-------------------

#### Sample

| Column | Type |
------------------
| Id | Int (Auto Increment) (PK) |
| Implementation | Text |
| LanguageId | Int (FK) |
| KataId | Int (FK)
-------------------

#### Language

| Column | Type |
------------------
| Id | Int (Auto Increment) (PK) |
| Name | String |
------------------

### Relationships

- Kata has many Samples
- Kata has many Languages
- Sample has a Language
- Sample has a Kata
- Language has many Samples
 


