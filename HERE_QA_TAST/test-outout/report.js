$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/JavaPractice/HERE_QA_TAST/src/main/java/features/documentation.feature");
formatter.feature({
  "line": 1,
  "name": "Here QA Task Documentatin Test",
  "description": "",
  "id": "here-qa-task-documentatin-test",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Here Documentation Test",
  "description": "",
  "id": "here-qa-task-documentatin-test;here-documentation-test",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "user is already launch application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "click on documentation tab",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "fetch all internal links in documentation section",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "iterate over the all internal links",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefenation.user_is_already_launch_application()"
});
formatter.result({
  "duration": 17477853600,
  "status": "passed"
});
formatter.match({
  "location": "StepDefenation.click_on_documentation_tab()"
});
formatter.result({
  "duration": 1348249900,
  "status": "passed"
});
formatter.match({
  "location": "StepDefenation.fetch_all_internal_links_in_documentation_section()"
});
formatter.result({
  "duration": 260519700,
  "status": "passed"
});
formatter.match({
  "location": "StepDefenation.iterate_over_the_all_internal_links()"
});
formatter.result({
  "duration": 294554779100,
  "status": "passed"
});
formatter.match({
  "location": "StepDefenation.close_the_browser()"
});
formatter.result({
  "duration": 968546700,
  "status": "passed"
});
});