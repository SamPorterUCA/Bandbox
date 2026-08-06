package org.summer26.section1.group8.bandbox;

import javax.management.relation.Role;

public class User {
    private final String userId;
    private final String password;
    private final String name;
    private final Role role;
    private final String branch;           // only meaningful for BRANCH_MANAGER
    private final boolean hasOverdueInvoice;

    public User(String userId, String password, String name, Role role, String branch, boolean hasOverdueInvoice) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.role = role;
        this.branch = branch;
        this.hasOverdueInvoice = hasOverdueInvoice;
    }

    public boolean isHasOverdueInvoice() {
        return hasOverdueInvoice;
    }

    public String getBranch() {
        return branch;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }

    public Role getRole() {
        return role;
    }
}
