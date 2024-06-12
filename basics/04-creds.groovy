pipeline {

    agent any

    environment {
        MY_CREDS = credentials('my-creds')
    }

    stages {
        stage('Test')
        {
            steps {

                sh('curl -u $MY_CREDS_USR:$MY_CREDS_PSW https://www.example.com')
                sh("curl -u MY_CREDS https://www.example.com")
            }
        }
    }
}