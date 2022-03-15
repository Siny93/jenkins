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


// pipeline {
//     agent any
//     parameters {
//         string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
//
//         text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')
//
//         booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')
//
//         choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')
//
//         password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
//     }
//     stages {
//         stage('Example') {
//             steps {
//                 echo "Hello ${params.PERSON}"
//
//                 echo "Biography: ${params.BIOGRAPHY}"
//
//                 echo "Toggle: ${params.TOGGLE}"
//
//                 echo "Choice: ${params.CHOICE}"
//
//                 echo "Password: ${params.PASSWORD}"
//             }
//         }
//     }
// }

// tools example

pipeline {
agent any
tools
{
maven 'maven'
}
stages
{
stage('maven')
{
steps
{
sh 'mvn --version'
}
}
}
}
}