pipeline {

    agent any
    
    parameters {
        string(name:'tag' , defaultValue: "empty now" , description: "Say Hello Boss")
    }

    stages {
        stage('hello')
        {
            steps
            {
                echo "${params.tag}"

                script {
                    env.tag = 'Latest Id'
                }
            }
        }

        stage('final stage')
        {
            steps
            {
                echo "${params.tag}"
            }
        }

    }
}