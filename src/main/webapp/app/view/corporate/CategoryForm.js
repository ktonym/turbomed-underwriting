Ext.define('EMIS.view.corporate.CategoryForm', {
    extend: 'Ext.form.Panel',
    xtype: 'categoryform',

    requires: [
        'Ext.form.FieldSet',
        'Ext.form.field.TextArea',
        'Ext.toolbar.Toolbar',
        'Ext.button.Button'
    ],

    width: 400,
    autoScroll: true,
    bodyPadding: 10,

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'fieldset',
                    padding: 10,
                    title: 'Category Entry',
                    items: [
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            fieldLabel: 'Category',
                            name: 'cat'
                        },
                        {
                            xtype: 'textareafield',
                            anchor: '100%',
                            fieldLabel: 'Description',
                            name: 'description'
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
                                    itemId: 'deleteBtn',
                                    iconCls: 'delete',
                                    text: 'Delete'
                                },
                                {
                                    xtype: 'button',
                                    itemId: 'addPrincipalBtn',
                                    iconCls: 'addnew',
                                    text: 'Add Member'
                                },
                                {
                                    xtype: 'button',
                                    itemId: 'saveBtn',
                                    iconCls: 'save',
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