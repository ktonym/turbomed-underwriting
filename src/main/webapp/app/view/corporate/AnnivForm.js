Ext.define('EMIS.view.corporate.AnnivForm', {
    extend: 'Ext.form.Panel',
    xtype: 'annivform',

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

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'fieldset',
                    width: 400,
                    fieldDefaults: 'anchor: 100%',
                    title: 'Policy Cover Entry',
                    items: [
                        {
                            xtype: 'numberfield',
                            anchor: '100%',
                            fieldLabel: 'Anniversary',
                            name: 'anniv'
                        },
                        {
                            xtype: 'fieldcontainer',
                            fieldLabel: 'Starts,Ends',
                            combineErrors: true,
                            layout: {
                                type: 'hbox',
                                align: 'stretch'
                            },
                            items: [
                                {
                                    xtype: 'datefield',
                                    flex: 1,
                                    fieldLabel: 'Label',
                                    hideLabel: true,
                                    name: 'startDate',
                                   // value: Ext.Date.now(),
                                    format: 'd-M-Y'
                                },
                                {
                                    xtype: 'datefield',
                                    flex: 1,
                                    fieldLabel: 'Label',
                                    hideLabel: true,
                                    name: 'endDate',
                                   // value: Ext.Date.add(Ext.Date.now(), Ext.Date.YEAR,1),
                                    format: 'd-M-Y'
                                }
                            ]
                        },
                        {
                            xtype: 'datefield',
                            anchor: '100%',
                            fieldLabel: 'Renewal date',
                            name: 'renewalDate',
                           // value: Ext.Date.add(Ext.Date.now(), Ext.Date.YEAR,1),
                            format: 'd-M-Y'
                        },
                        {
                            xtype: 'combobox',
                            anchor: '100%',
                            fieldLabel: 'Intermediary',
                            name: 'intermediary',
                            queryMode: 'local',
                            store: 'Intermediary',
                            valueField: 'idIntermediary',
                            listConfig: {
                                minwidth: 300
                            },
                            tpl: Ext.create('Ext.XTemplate','<tpl for=".">',
                                '<div class="x-boundlist-item"><b>{intermediaryName}</b></div>','</tpl>'),
                            displayTpl: Ext.create('Ext.XTemplate','<tpl for=".">','{intermediaryName}','</tpl>')
                        },
                        {
                            xtype: 'toolbar',
                            ui: 'footer',
                            layout: {
                                type: 'hbox',
                                pack: 'end'
                            },
                            items: [
                                {
                                    xtype: 'button',
                                    iconCls: 'delete',
                                    text: 'Delete',
                                    itemId: 'deleteBtn'
                                },
                                {
                                    xtype: 'button',
                                    iconCls: 'addnew',
                                    text: 'Add Category',
                                    itemId: 'addCategoryBtn'
                                },
                                {
                                    xtype: 'button',
                                    iconCls: 'save',
                                    text: 'Save',
                                    itemId: 'saveBtn'
                                }
                            ]
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});