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

        var agents = Ext.create('Ext.data.Store',{
            fields: ['id','name'],
            data: [
                {"id":1,"name":"Shikutwa"},
                {"id":2,"name":"Naliaka"},
                {"id":3,"name":"Nafula"},
                {"id":4,"name":"Shikwekwe"},
                {"id":5,"name":"Shikokoti"}
            ]
        });

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
                                  //  value: Ext.Date.getFirstDateOfMonth(now),
                                    format: 'd-M-Y'
                                },
                                {
                                    xtype: 'datefield',
                                    flex: 1,
                                    fieldLabel: 'Label',
                                    hideLabel: true,
                                    name: 'endDate',
                                  //  value: Ext.Date.add(Ext.Date.getFirstDateOfMonth(now), Ext.Date.YEAR,1),
                                    format: 'd-M-Y'
                                }
                            ]
                        },
                        {
                            xtype: 'datefield',
                            anchor: '100%',
                            fieldLabel: 'Renewal date',
                            name: 'renewalDate',
                           // value: Ext.Date.add(Ext.Date.add(Ext.Date.getFirstDateOfMonth(now), Ext.Date.YEAR,1), Ext.Date.DAY,1),
                            format: 'd-M-Y'
                        },
                        {
                            xtype: 'combobox',
                            anchor: '100%',
                            fieldLabel: 'Intermediary',
                            name: 'name',
                            queryMode: 'local',
                            store: agents,
                            valueField: 'id'
//                            listConfig: {
//                                minWidth: 300
//                            },
//                            tpl: Ext.create('Ext.XTemplate','<tpl for=".">',
//                                '<div class="x-boundlist-item"><b>{intermediaryName}</b></div>','</tpl>'),
//                            displayTpl: Ext.create('Ext.XTemplate','<tpl for=".">','{intermediaryName}','</tpl>')
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