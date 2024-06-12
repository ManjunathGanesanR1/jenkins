pipeline {

    agent any

    stages {

        stage ('test') {

            steps {
                echo "Hello world"
            }

            post {

                always {
                    echo "I will be executed always"
                }
                success {
                    echo " I am success"
                }
                failure {
                    echo "I am failue"
                }
            }
        }
    }

}