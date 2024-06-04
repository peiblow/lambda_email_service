## Lambda Email

<br/>

#### 🇧🇷: Apenas uma lambda que é executado quando uma nova mensagem SQS é recebia e efetua o disparo de emails.

#### 🇺🇸: Just a lambda function that will be executed when a new sqs message arrives and so send the email

<br/>

## * Como / How to execute
### * Before run this lambda function you need this env var set created with your localstack service url, and remember to check your `AWS_PROFILE`

```
AWS_S3_ENDPOINT_URL
```

#### 🇧🇷: Todo o ambiente necessario para a execução do programa está pronto para ser executado através do arquivo `init.sh` mas para roda-lo antes você vai precisar do [AWS SAM-CLI](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/install-sam-cli.html)

#### 🇺🇸: All the enviroment you need to execute the project local, are ready to be executed through the file `init.sh` but before you will need to [AWS SAM-CLI](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/install-sam-cli.html)

## Tecnologias Usadas / Tech stack on this project:

* Java 17
* Spring Boot 2
* localstack - Lambda
* AWS SAM