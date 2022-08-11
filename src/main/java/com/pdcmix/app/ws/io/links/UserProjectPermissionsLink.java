package com.pdcmix.app.ws.io.links;

public class UserProjectPermissionsLink {
    
}

// https://stackoverflow.com/questions/42488559/manytomany-relationship-between-three-tables

// class User {
//     @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//     private Set<UserDepartmentRoleLink> userDepartmentRoleLinks;
// }

// class Department{
//     @OneToMany(mappedBy = "department", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//     private Set<UserDepartmentRoleLink> userDepartmentRoleLinks;
// }

// class Role{
//     @OneToMany(mappedBy = "role", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//     private Set<UserDepartmentRoleLink> userDepartmentRoleLinks;
// }

// class UserDepartmentRoleLink {

//     @Id
//     @GeneratedValue
//     private Long id;

//     @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//     @JoinColumn(name = "user_id")
//     private User user;

//     @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//     @JoinColumn(name = "department_id")
//     private Department department;

//     @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//     @JoinColumn(name = "role_id")
//     private Role role;

// }
