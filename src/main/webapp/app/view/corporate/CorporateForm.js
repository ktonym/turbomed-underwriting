Ext.define("EMIS.view.corporate.CorporateForm", {
    extend: 'Ext.form.Panel',
    xtype: 'corporateform',
    requires: ['Ext.form.FieldSet','Ext.form.field.Date',
        'Ext.form.field.Number','Ext.form.field.TextArea','Ext.toolbar.Toolbar'],
    layout: {
        type: 'anchor'
    },
    bodyPadding: 10,
    border: false,
    autoScroll: true,
    initComponent: function(){
        var me = this;
        Ext.applyIf(me,{
            items: [{
               xtype: 'fieldset',
                padding: 10,
                fieldDefaults: {
                    anchor: '100%'
                },
                title: 'Corporate Entry',
                items: [{
                    xtype: 'textfield',
                    name: 'corporateName',
                    fieldLabel: 'Name'
                },{
                    xtype: 'textfield',
                    name: 'abbreviation',
                    fieldLabel: 'Abbreviation'
                },{
                    xtype: 'textfield',
                    name: 'tel',
                    fieldLabel: 'Tel'
                },{
                    xtype: 'textfield',
                    name: 'email',
                    fieldLabel: 'Email'
                },{
                    xtype: 'textfield',
                    name: 'postalAddress',
                    fieldLabel: 'Postal Address'
                },{
                    xtype: 'datefield',
                    labelAlign: 'right',
                    name: 'joined',
                    format: 'd-M-Y',
                    fieldLabel: 'Join Date',
                    value: Ext.Date.now(),
                    width: 180,
                    labelWidth: 70
                },{
                    xtype: 'toolbar',
                    ui: 'footer',
                    layout: {
                        pack: 'end',
                        type: 'hbox'
                    },
                    items: [{
                        xtype: 'button',
                        itemId: 'deleteBtn',
                        iconCls: 'delete',
                        text: 'Delete'
                    },{
                        xtype: 'button',
                        itemId: 'addAnnivBtn',
                        iconCls: 'addnew',
                        text: 'Add Cover'
                    },{
                        xtype: 'button',
                        itemId: 'saveBtn',
                        iconCls: 'save',
                        text: 'Save'
                    }]
                }]

            }]
        });
        me.callParent(arguments);
    }
});