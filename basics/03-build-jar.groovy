pipeline 
{
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Check out')
        {
            steps {
                echo "I am going to take check out"
                git branch:'main' , credentialsId: 'github-creds', url: 'https://github.com/ManjunathGanesanR1/jenkins.git'
            }
        }

        stage('build Jar')
        {
            steps {
                echo "I am going to build now"
                sh '''
                    mvn --version
                    cd spring-jenkins
                    mvn clean package -DskipTests
                 '''
            }
        }
    }
}