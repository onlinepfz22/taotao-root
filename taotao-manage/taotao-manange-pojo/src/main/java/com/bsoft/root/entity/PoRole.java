package com.bsoft.root.entity;

public class PoRole {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column po_role.ID
     *
     * @mbg.generated Thu Jun 21 16:25:47 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column po_role.ROLENAME
     *
     * @mbg.generated Thu Jun 21 16:25:47 CST 2018
     */
    private String roleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column po_role.STATUS
     *
     * @mbg.generated Thu Jun 21 16:25:47 CST 2018
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column po_role.ID
     *
     * @return the value of po_role.ID
     *
     * @mbg.generated Thu Jun 21 16:25:47 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column po_role.ID
     *
     * @param id the value for po_role.ID
     *
     * @mbg.generated Thu Jun 21 16:25:47 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column po_role.ROLENAME
     *
     * @return the value of po_role.ROLENAME
     *
     * @mbg.generated Thu Jun 21 16:25:47 CST 2018
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column po_role.ROLENAME
     *
     * @param roleName the value for po_role.ROLENAME
     *
     * @mbg.generated Thu Jun 21 16:25:47 CST 2018
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column po_role.STATUS
     *
     * @return the value of po_role.STATUS
     *
     * @mbg.generated Thu Jun 21 16:25:47 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column po_role.STATUS
     *
     * @param status the value for po_role.STATUS
     *
     * @mbg.generated Thu Jun 21 16:25:47 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}