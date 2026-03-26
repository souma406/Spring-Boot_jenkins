pipeline {
    agent any 

    environment {
        IMAGE_NAME = "simple-todo-api"
    }

    stages {
        stage('Checkout Git') {
            steps {
                checkout scm
            }
        }

        stage('Build Spring Boot') {
            steps {
                echo 'Construction de l\'application avec Maven...'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                echo 'Création de l\'image Docker...'
                sh "docker build -t ${IMAGE_NAME}:${BUILD_NUMBER} ."
            }
        }
    }

    post {
        always {
            
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
        
        success {
    
            emailext (
                subject: "SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                body: "Le build de l'application Spring Boot est réussi. \nURL: ${env.BUILD_URL}",
                to: '24406@esp.mr' 
            )
        }

        failure {
           
            emailext (
                subject: "FAILURE: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                body: "Le build a échoué. Consultez les logs ici: ${env.BUILD_URL}console",
                to: '24406@esp.mr' 
            )
        }
    }
}