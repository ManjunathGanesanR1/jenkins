pipeline
{
    agent any

    stages {
        stage('list Helm releases and the repostories')
        {
            steps {
                script {
                    echo "I am going to list the releases"
                    
                    sh '''
                    helm ls
                    helm repo add lekka https://manjunathganesanr1.github.io/lekka/
                    helm repo update
                    helm search repo lekka
                    '''

                }
            }
        }

        stage('Deploy the release')
        {
            steps {
                script {

                    
                    def releaseExists = sh(
                        script: "helm ls | grep -w lekka-svc",
                        returnStatus: true
                    ) == 0

                    echo "Does release Exists ${releaseExists}"

                    if (releaseExists)
                    {
                        echo "Release already exists"
                    }
                    else
                    {
                        sh '''
                        helm install lekka-svc lekka/service-registry
                        '''
                    }

                }
            }
        }
    }
}