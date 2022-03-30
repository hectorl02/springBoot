# springBoot
fundamentos de spring boot
*get: http://localhost:8081/app-hector/api/users/
*post: http://localhost:8081/app-hector/api/users/
  *body: {
		"name": "userXXX",
		"email": "Userxxx@mail.com",
		"birthDate": "2003-01-12"
	}
  *put: http://localhost:8081/app-hector/api/users/{id}
   *body: {
		"name": "userXXXEd",
		"email": "Userxxx_ed@mail.com",
		"birthDate": "2003-01-12"
	}
  *delete:http://localhost:8081/app-hector/api/users/{id}
  *paginator: http://localhost:8081/app-hector/api/users/pageable?page=1&size=4
