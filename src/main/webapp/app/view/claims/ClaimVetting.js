Ext.define("EMIS.view.claims.ClaimVetting", {
    extend: 'Ext.form.Panel',
    xtype: 'claimvetting',

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
                    title: 'Claim Vetting',
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