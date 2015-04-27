Ext.define('EMIS.view.corporate.PrincipalWindow', {
    extend: 'Ext.window.Window',

    xtype: 'principalwindow',

    requires: [
        'Ext.form.FieldSet',
        'Ext.form.FieldContainer',
        'Ext.form.field.Date',
        'Ext.form.field.Hidden',
        'Ext.toolbar.Toolbar',
        'Ext.button.Button'
    ],

    height: 217,
    width: 514,
    bodyPadding: 10,
    iconCls: 'logo-small',
    title: 'Principal Form',

    layout: {
        type: 'vbox',
        align: 'stretch'
    },

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'form',
                    flex: 1,
                    itemId: 'principalform',
                    items: [
                            {
                            xtype: 'fieldset',
                            flex: 1,
                            title: 'Add New Principal',
                            items: [
                                {
                                    xtype: 'fieldcontainer',
                                    fieldLabel: 'Name',
                                    layout: {
                                        type: 'hbox',
                                        align: 'stretch'
                                    },
                                    items: [
                                        {
                                            xtype: 'textfield',
                                            flex: 1,
                                            hideLabel: true,
                                            name: 'firstName',
                                            emptyText: 'First name'
                                        },
                                        {
                                            xtype: 'textfield',
                                            flex: 1,
                                            hideLabel: true,
                                            name: 'surname',
                                            emptyText: 'Surname'
                                        }
                                    ]
                                },
                                {
                                    xtype: 'textfield',
                                    width: 284,
                                    fieldLabel: 'Other Name',
                                    name: 'otherNames',
                                    emptyText: 'Enter other name(s)'
                                },
                                {
                                    xtype: 'datefield',
                                    anchor: '100%',
                                    fieldLabel: 'Date of birth',
                                    name: 'dob'
                                },
                                {
                                    xtype: 'hiddenfield',
                                    anchor: '100%',
                                    fieldLabel: 'Label',
                                    name: 'idCategory'
                                }
                            ]
                        }
                    ],
                    dockedItems: [
                        {
                            xtype: 'toolbar',
                            flex: 1,
                            dock: 'bottom',
                            ui: 'footer',
                            layout: {
                                type: 'hbox',
                                pack: 'end'
                            },
                            items: [
                                {
                                    xtype: 'button',
                                    iconCls: 'delete',
                                    itemId: 'deleteBtn',
                                    text: 'Delete'
                                },
                                {
                                    xtype: 'button',
                                    iconCls: 'addnew',
                                    itemId: 'addMemberBtn',
                                    text: 'Add Member'
                                },
                                {
                                    xtype: 'button',
                                    iconCls: 'save',
                                    itemId: 'saveBtn',
                                    text: 'Save'
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