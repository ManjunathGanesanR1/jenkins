pipeline {
    agent any

    stages {

        stage('Check Out') {

            steps {

                script {
                    
                    def job1 = build job : 'job1' , propagate : true , wait : 'true'

                    echo "Job 1 result is ${job1.result}"
                    echo "Job 1 build number is ${job1.id}"
                    
                    def job1Output = job1.getBuildVariables()['OUTPUT']
                    echo "Output is ${job1Output}"

                    currentBuild.description = "Output is ${job1Output}"
                    env.JOB1OUTPUT = job1Output
                }
            }
        }

        stage('Build') {
            steps {

                def job2 = build job : 'job2' , propagate : true , wait : true , parameters : [
                    string(name: 'INPUT', value : env.JOB1OUTPUT)
                ]
                echo "Job2 result is ${job2.result}"
                echo "Job2 build number is ${job2.id}"

                def job2Output = job2.getBuildVariables()['OUTPUT']
                echo "Job2 output is ${job2Output}"

                currentBuild.description = "Job2 output is ${job2Output}"
                env.JOB2OUTPUT = job2Output

            }
        }

        stage('Deploy') {
            steps {
                def job3 = build job : 'job3', propagate : true , wait : true , parameters : [
                    string(name : 'INPUT' , value : env.JOB2OUTPUT)
                ]
                echo "Job3 result is ${job3.result}"
                echo "Job3 build number is ${job3.id}"

                def job3Output = job3.getBuildVariables()['OUTPUT']
                echo "Job3 output is ${job3Output}"

                currentBuild.description = "Job3 output is ${job3Output}"
                env.JOB3OUTPUT = job2Output

            }
        }
    }
}