pipeline {
agent any
environment {
ANSIBLE_INVENTORY = 'inventory.ini'
ANSIBLE_PLAYBOOK = 'playbook.yml'
    }
stages {
stage('Checkout') {
steps {
git branch: 'main', url: 'https://github.com/souma406/Spring-Boot_jenkins.git'
}
}
stage('Install Ansible') {
steps {
sh 'sudo apt-get update'
sh 'sudo apt-get install -y ansible'
}
}
stage('Run Ansible Playbook') {
steps {
ansiblePlaybook(
playbook: "${ANSIBLE_PLAYBOOK}",
inventory: "${ANSIBLE_INVENTORY}"
)
}
}
}
}
