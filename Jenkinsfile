// pipeline {
//     agent any
//
//     stages {
//         stage('Hello') {
//             steps {
//                 echo 'Hi siny'
//             }
//         }
//         stage('hi') {
//             steps {
//                 echo 'Hi world'
//             }
//         }
//     }
//
// }


// pipeline {
//   agent any
//   environment {
//   URL1 = "google.com"
//   SSH = credentials("CENTOS")
//   SSH1 = credentials("common/ssh")
//   }
// stages {
// stage ('ONE') {
// steps {
// sh 'echo ${URL1}'
// sh 'env'
// echo SSH
// sh 'echo ${SSH1} | base64'
// }
//
// }
//
// }
// }



// tools example

// pipeline {
// agent any
// tools
// {
// maven 'maven'
// }
// stages
// {
// stage('maven')
// {
// steps
// {
// sh 'mvn --version'
// }
// }
// }
// }
// }

pipeline {
    agent any
    stages {
        stage('Example') {
            input {
                message "Should we continue?"
                ok "Yes, we should."
                submitter "alice,bob"
                parameters {
                    string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
                }
            }
            steps {
                echo "Hello, ${PERSON}, nice to meet you."
            }
        }
    }
}