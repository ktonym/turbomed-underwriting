Ext.define("EMIS.view.LogonWindow", {
    extend: 'Ext.window.Window',
    xtype: 'logonwindow',
    closable: false,
    iconCls: 'fa fa-key fa-lg',//iconCls: 'logo-small',
    width: 300,
    bodyPadding: 10,
    title: 'EMIS Logon',
    requires: ['Ext.form.field.Text'],
    initComponent: function(){
        var me=this;
        Ext.applyIf(me,{
            items: [{
                xtype: 'textfield',
                fieldLabel: 'User Name',
                name: 'username',
                allowBlank: false,
                validateOnBlur: true,
                emptyText: 'Enter a username'
            },{
                xtype: 'textfield',
                name: 'password',
                fieldLabel: 'Password',
                inputType: 'password',
                validateOnBlur: true,
                allowBlank: false
            },{
                xtype: 'toolbar',
                ui: 'footer',
                layout: {
                    pack: 'end',
                    type: 'hbox'
                },
                items: [{
                    xtype: 'button',
                    text: 'Logon'
                }]
            }]
        });
        me.callParent(arguments);
    }
});