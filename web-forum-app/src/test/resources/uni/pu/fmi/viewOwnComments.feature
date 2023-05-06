Feature: Визуализиране на свои коментари

  Scenario Outline: 
    Given Натискаме бутона My Comments от менюто
    When Проверява се дали сме направили коментари преди: "<currentUserId>"
    And Прави се заявка към базата данни
    Then Виждаме съобщение относно резултата: "<resultMessage>"
    
		# user2 has comments 
		# user3 has no comments 
    Examples: 
      | currentUserId   | resultMessage 									     	 |                           				    
   	  | 2               | Коментарите се визуализираха успешно.  |    
   	  | 3               | Потребителят няма коментар!            |    
 