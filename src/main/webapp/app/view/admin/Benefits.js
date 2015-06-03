Ext.define("EMIS.view.admin.Benefits", {

    extend: 'Ext.ux.LiveSearchGridPanel',

    xtype: 'benefitgrid' ,

    columnLines: true,

    viewConfig: {
        stripeRows: true
    },

    store: 'BenefitRef',

    initComponent: function(){
        var me=this;

        me.selModel = {
            selType: 'cellmodel'
        };

        me.plugins = [
            {
                ptype: 'cellediting',
                clicksToEdit: 2,
                pluginId: 'cellplugin'
            },
            {
                ptype: 'gridfilters'
            }
        ];

        me.dockedItems = [
            {
                xtype: 'toolbar',
                dock: 'top',
                itemId: 'topToolbar',
                items: [
                    {
                        xtype: 'button',
                        itemId: 'add',
                        text: 'Add'
                        //glyph: EMIS.util.Glyphs.getGlyph('add')
                    },
                    {
                        xtype: 'tbseparator'
                    },
                    {
                        xtype: 'button',
                        itemId: 'save',
                        text: 'Save Changes'
                        //glyph: EMIS.util.Glyphs.getGlyph('saveAll')
                    },
                    {
                        xtype: 'button',
                        itemId: 'cancel',
                        text: 'Cancel Changes'
                        //glyph: EMIS.util.Glyphs.getGlyph('cancel')
                    },
                    {
                        xtype: 'tbseparator'
                    },
                    {
                        xtype: 'button',
                        itemId: 'clearFilter',
                        text: 'Clear Filters'
                        //glyph: EMIS.util.Glyphs.getGlyph('clearFilter')
                    }
                ]
            }
        ];

        me.columns = [
            {
                xtype: 'gridcolumn',
                dataIndex: 'benefitCode',
                flex: 1,
                text: 'Benefit Code'
            },
            {
                xtype: 'gridcolumn',
                dataIndex: 'benefitName',
                flex: 1,
                text: 'Benefit'
            },
            {
                xtype: 'gridcolumn',
                dataIndex: 'description',
                flex: 1,
                text: 'description'
            }
        ];

        me.validateRow = function(record, rowIndex){

            var me = this,
                view = me.getView(),
                errors = record.validate();

            if (errors.isValid()){
                return true;
            }

            var columnIndexes = me.getColumnIndexes();

            me.getColumnIndexes = function() {
                var me = this,
                    columnIndexes = [];
                Ext.Array.each(me.columns, function (column) { //#9
                    if (Ext.isDefined(column.getEditor())) { //#10
                        columnIndexes.push(column.dataIndex); //#11
                    } else {
                        columnIndexes.push(undefined);
                    }
                });
                return columnIndexes; //#12
            };

            me.validate = function(){

                var me = this,
                    isValid = true,
                    view = me.getView(),
                    error,
                    record;

                Ext.each(view.getNodes(), function (row,col){
                   record = view.getRecord(row);
                    isValid = (me.validateRow(record, col) && isValid);
                });

                error = isValid ? undefined : {
                    title: "Invalid Records",
                    message: "Please fix errors before saving."
                };
                return error;
            }

            Ext.each(columnIndexes, function (columnIndex, col) {
                var cellErrors, cell, messages;
                cellErrors = errors.getByField(columnIndex);
                if (!Ext.isEmpty(cellErrors)) {
                    cell = view.getCellByPosition({
                        row: rowIndex, column: col
                    });
                    messages = [];
                    Ext.each(cellErrors, function (cellError) {
                        messages.push(cellError.message);
                    });
                    cell.addCls('x-form-error-msg x-form-invalid-icon x-form-invalid-icon-default');
                    cell.set({
                        'data-errorqtip': Ext.String.format('<ul><li class="last">{0}</li></ul>',
                    messages.join('<br/>'))
                    });
                }
            });
        return false;
    };


        me.callParent(arguments);
    }
});