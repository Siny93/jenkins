def call() {


    pipeline {
        agent {
            label "${BUILD_LABEL}"
        }



        //environment {}

        parameters {


            choice(name: 'Env', choices: ['', 'dev', 'prod'], description: 'Choose Env')
            choice(name: 'Action', choices: ['', 'apply', 'destroy'], description: 'Choose Action')


        }

        stages {

            stage('label builds') {
                steps {
                    script {

                        addShortText background: 'white', borderColor: 'white', color: 'red', link: '', text: "${Env}"
                        addShortText background: 'white', borderColor: 'white', color: 'red', link: '', text: "${Action}"
                    }
                }
            }


            stage('Apply terraform action') {
                steps {
                    sh '''
                      terraform init -backend-config=env/${Env}-backend.tfvars
                      terraform ${Action} -auto-approve=env/${Env}.tfvars
                    '''
                }
            }

        }



        post {
            always {
                cleanWs()
            }

        }

    }
}
