Ext.define("EMIS.view.admin.AccountMapping", {

    extend: 'Ext.form.Panel',

    xtype: 'accountmapping',

    requires: [
        'Ext.form.FieldSet',
        'Ext.form.field.Number',
        'Ext.form.FieldContainer',
        'Ext.form.field.Date',
        'Ext.form.field.ComboBox',
        'Ext.toolbar.Toolbar',
        'Ext.button.Button'
    ],

    autoScroll: true,
    bodyPadding: 10,

    initComponent: function(){

        var me = this;
        Ext.applyIf(me,{
            items: [
                {
                    xtype: 'fieldset',
                    width: 400,
                    fieldDefaults: 'anchor: 100%',
                    title: 'Account Mapping',
                    items: [
                        {

                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }
});