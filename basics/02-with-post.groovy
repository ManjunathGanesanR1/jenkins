pipeline {
    agent any

    stages {

        stage('With post')
        {
            steps {
                echo "Hello with post"
            }

            post {
                success {
                   script {
                    currentBuild.status = 'Failure'
                   } 
                }
            }
        }
    }

    post {
        always {
            echo "I will echo always"
        }
    }

}