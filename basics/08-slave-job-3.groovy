pipeline
{
    agent any

    parameters {
        string(name : 'INPUT' , defaultValue: 'job3' , description:'Details for Deployment')
    }

    stages {
        stage('Bro Go Deploy') {
            steps{
                script {
                    echo "Received Input ${params.INPUT}"

                    def output = "${params.INPUT}_DEPLOYMENT_SUCCESS"
                    echo "Output is ${output}"

                    currentBuild.description = "Output is ${output}"
                    env.OUTPUT = output
                }
            }
        }
    }
}