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

// pipeline {
//     agent any
//     stages {
//         stage('Example') {
//             input {
//                 message "Should we continue?"
//                 ok "Yes, we should."
//                 submitter "siny,bob"
//                 parameters {
//                     string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
//                 }
//             }
//             steps {
//                 echo "Hello, ${PERSON}, nice to meet you."
//             }
//         }
//     }
// }





// pipeline {
//     agent any
//     parameters {
//       choice(name: 'ENV', choices: ['DEV', 'PROD'], description: 'choose ENV')
//     }
//     stages {
//         stage('DEV') {
//         when {
//         environment name: 'ENV', value: 'DEV'
//         }
//             steps {
//                 echo "DEV"
//             }
//         }
//         stage('PROD') {
//             when {
//                 environment name: 'ENV', value: 'PROD'
//             }
//             steps {
//                 echo "PROD"
//             }
//         }
//     }
// }

pipeline {
agent any
stages {
stage('one-sequential') {
steps {
sh 'sleep 45'
}
}

stage('two-parallel') {
parallel {
stage('two1') {
steps {
sh 'sleep 60'
}
}

stage('two2') {
steps {
sh 'sleep 90'
}
}
}
}
}
}