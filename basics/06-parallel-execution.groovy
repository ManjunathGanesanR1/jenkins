pipeline
{
    agent any

    parameters {
        string( name:'tag', defaultValue:'Empty' , description:'Sample tag')
    }

    stages {
        
        stage("Parallel"){
            parallel {
            stage('stage 1')
            {
                steps {
                    echo "${params.tag}"
                }
            }

            stage('stage 2')
            {
                steps{
                    echo "Hello Boss"
                }
                
            }
        }
        }
        
    }

}