cd ..
export AWS_PROFILE=localstack
sam build
sam package --template-file .aws-sam/build/template.yaml --s3-bucket lambda-functions  --output-template-file packaged.yaml
sam deploy packaged.yaml --stack-name EmailServiceFunction --capabilities CAPABILITY_IAM --resolve-s3
