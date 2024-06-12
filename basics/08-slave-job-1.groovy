pipeline
{
    agent any

    parameters {
        string(name:'INPUT' , defaultValue:'job1' , description:'Sample Input')
    }

    stages {

        stage('I am going to check out')
        {
            steps{
                script {

                    echo "Received Input ${params.INPUT}"

                    def output = "CHECK_OUT_SUCCESS"
                    echo "Output is  ${output}"

                    currentBuild.description = "Output is  ${output}"
                    env.OUTPUT = output
                }
            }
        }
    }
}