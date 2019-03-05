Feature: Get http server request
  Scenario: User calls web service to get OK Status code
	    Given a request http get
	    When a user retrieves index
	    Then the status code is 200
  Scenario: User calls web service to get NOT_FOUND Status code
	    Given a request http get not found
	    When a user retrieves a not found resource
	    Then the status code not found is 404
  Scenario: User calls web service to get NOT_IMPLEMENTED Status code
	    Given a request http different method
	    When a user retrieves by method not implemented
	    Then the status code not_implemented is 501