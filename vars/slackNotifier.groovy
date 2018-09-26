#!/usr/bin/env groovy

def call(String buildResult,string SLACK_CHANNEL) {
  if ( buildResult == "SUCCESS" ) {
    slackSend color: "good", channel: "${params.SLACK_CHANNEL}", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was successful - ${env.BUILD_URL}"
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend color: "danger", channel: "${params.SLACK_CHANNEL}", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was failed - ${env.BUILD_URL}"
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend color: "warning", channel: "${params.SLACK_CHANNEL}", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was unstable - ${env.BUILD_URL}"
  }
  else {
    slackSend color: "danger", channel: "${params.SLACK_CHANNEL}", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} its resulat was unclear - ${env.BUILD_URL}"	
  }
}
