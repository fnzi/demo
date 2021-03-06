package cn.tj.baseextweb.fw.entity;

// Generated 2014-9-10 22:31:18 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "tab_role")
public class Role implements java.io.Serializable {

    private Long rid;
    private String endTime;
    private String rname;
    private String startTime;
    private Set<RefRoleFunction> refRoleFunctions = new HashSet<RefRoleFunction>(0);
    private Set<User> users = new HashSet<User>(0);

    public Role() {
    }

    public Role(String endTime, String rname, String startTime, Set<RefRoleFunction> refRoleFunctions, Set<User> users) {
        this.endTime = endTime;
        this.rname = rname;
        this.startTime = startTime;
        this.refRoleFunctions = refRoleFunctions;
        this.users = users;
    }

    @Id
    @GeneratedValue
    @Column(name = "rid", unique = true, nullable = false)
    public Long getRid() {
        return this.rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    @Column(name = "endtime")
    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Column(name = "rname")
    public String getRname() {
        return this.rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    @Column(name = "starttime")
    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    public Set<RefRoleFunction> getRefRoleFunctions() {
        return this.refRoleFunctions;
    }

    public void setRefRoleFunctions(Set<RefRoleFunction> refRoleFunctions) {
        this.refRoleFunctions = refRoleFunctions;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
