#!/usr/bin/env groovy

def call(String buildResult, String SLACK_CHANNEL) {
  if ( buildResult == "STARTED" ) {
    slackSend (color: "good", channel: "${params.SLACK_CHANNEL}", message: "*STARTED:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}.\n More info at: ${env.BUILD_URL}")
  }
  else if ( buildResult == "SUCCESS" ) {
    slackSend (color: "good", channel: "${params.SLACK_CHANNEL}", message: "*SUCCESS:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}. \n More info at: ${env.BUILD_URL}")
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend (color: "danger", channel: "${params.SLACK_CHANNEL}", message: "*FAILED:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}. \n More info at: ${env.BUILD_URL}")
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend (color: "warning", channel: "${params.SLACK_CHANNEL}", message: "*UNSTABLE:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}. \n More info at: ${env.BUILD_URL}")
  }
  else 
  {
    slackSend (color: "danger", channel: "${params.SLACK_CHANNEL}", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} its resulat was unclear - ${env.BUILD_URL}")
  }
}
