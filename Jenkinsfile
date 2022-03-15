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


pipeline {
  agent any
  environment {
  URL1 = "google.com"
  SSH = credentials("CENTOS")
  SSH1 = credentials("newrelic-api-key")
  }
stages {
stage ('ONE') {
steps {
sh 'echo ${URL1}'
sh 'env'
echo SSH
sh 'echo ${SSH1} | base64'
}


}

}


}