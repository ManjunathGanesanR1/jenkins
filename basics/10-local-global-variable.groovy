pipeline {
    agent any

    environment {
        VARVAL='Global'
    }

    stages {

        stage('locally')
        {
            agent { label 'build'}

            environment {
                 VARVAL='Local'
            }

            steps {
                echo "I am printing the $VARVAL"
            }
        }

        stage('Default')
        {
            agent { label 'build'}
            
            steps {
                echo "I am printing the $VARVAL"
            }
        }
    }
}