pipeline
{
    agent any

    parameters {
        string(name: 'INPUT' , defaultValue: 'job2' , description:'Building with inputs')
    }

    stages {
        stage('Build it bro')
        {
            steps {
                script {
                    echo "Received Input ${params.INPUT}"

                    def output = "${params.INPUT}_BUILD_SUCCESS"
                    echo "Output is ${output}"

                    currentBuild.description = "Output is ${output}"
                    env.OUTPUT = output
                }
            }
        }
    }
}