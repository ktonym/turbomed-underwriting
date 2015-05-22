Ext.define("EMIS.view.claims.ClaimEntry", {
    extend: 'Ext.form.Panel',
    xtype: 'claimentry',

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

        var me = this,
            providers = Ext.create('Ext.data.Store',{
                fields: ['idProvider','providerName'],
                data: [
                    {"idProvider":1,"providerName":"The Aga Khan University Hospital"},
                    {"idProvider":2,"providerName":"The Mater Hospital"},
                    {"idProvider":3,"providerName":"The Nairobi Hospital"},
                    {"idProvider":4,"providerName":"Mama Lucy Hospital"},
                    {"idProvider":5,"providerName":"Avenue Hospital"}
                ]
            });
        Ext.applyIf(me,{
            items: [
                {
                    xtype: 'fieldset',
                    width: 400,
                    fieldDefaults: 'anchor: 100%',
                    title: 'Claim Entry',
                    items: [
                        {
                            xtype: 'fieldcontainer',
                            combineErrors: false,
                            layout: {
                                type: 'hbox',
                                align: 'stretch'
                            },
                            items: [        {
                                    xtype: 'textfield',
                                    name: 'memberNo',
                                    fieldLabel: 'Member Number'
                                },
                                {
                                    xtype: 'combobox',
                                    fieldLabel: 'providerName',
                                    name: 'idProvider',
                                    queryMode: 'local',
                                    store: providers,
                                    valueField: 'idProvider'//,
//                                    listConfig: {
//                                        minWidth: 300
//                                    },
//                                    tpl: Ext.create('Ext.XTemplate','<tpl for=".">','<div class="x-boundlist-item"><b>{providerName}</b></div>','</tpl>'),
//                                    displayTpl: Ext.create('Ext.XTemplate','<tpl for=".">','{providerName}','</tpl>')
                                }
                            ]
                        },
                        {
                            xtype: 'fieldcontainer',
                            combineErrors: true,
                            layout: {
                                type: 'hbox',
                                align: 'stretch'
                            },
                            items: [
                                {
                                    xtype: 'textfield',
                                    fieldLabel: 'Invoice No.',
                                    name: 'invoiceNo',
                                    emptyText: 'Enter invoice no'
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: 'Claim No.',
                                    name: 'claimNo'
                                }
                            ]
                        },
                        {
                            xtype: 'datefield',
                            name: 'invoiceDate',
                            fieldLabel: 'Invoice Date'
                        },
                        {
                            xtype: 'datefield',
                            name: 'enteredDate',
                            fieldLabel: 'Date Entered'
                        },
                        {
                            xtype: 'textfield',
                            name: 'benefit',
                            fieldLabel: 'Benefit'
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }
});