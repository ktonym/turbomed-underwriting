Ext.define('EMIS.controller.CorpController', {
    extend: 'Ext.app.Controller',
    views: ['corporate.ManageUsers'],
    refs: [{
        ref: 'corpForm',
        selector: 'managecorporates corporateform'
    },{
        ref: 'corpList',
        selector: 'managecorporates corporatelist'
    },{
        ref: 'corpFormFieldset',
        selector: 'managecorporates corporateform fieldset'
    },{
        ref: 'addCorpButton',
        selector: 'managecorporates #addCorpBtn'
    },{
        ref: 'delCorpButton',
        selector: 'managecorporates corporateform #deleteBtn'
    },{
        ref: 'saveCorpButton',
        selector: 'managecorporates corporateform #saveBtn'
    }
    ],
    init: function(application){
        this.control({
            'managecorporates #addCorpBtn': {
                click: this.doAddCorporate
            },
            'managecorporates corporatelist':{
                itemclick: this.doSelectCorporate,
                viewready: this.doInitStore
            },
            'managecorporates corporateform': {
                afterrender: this.doAddCorporate
            },
            'managecorporates corporateform fieldset': {
                click: this.doRefreshCorpList
            },
            'managecorporates corporateform #saveBtn': {
                click: this.doSaveCorporate
            },
            'managecorporates corporateform #deleteBtn': {
                click: this.doDeleteCorporate
            }
        });
    },

    doInitStore: function(){
        this.getCorpList().getStore().load()
    },

    doRefreshCorpList: function(){
        this.getCorpList().getStore().load()
    },

    doAddCorporate: function(){
        var me = this;
        me.getCorpFormFieldset().setTitle('Add New Corporate');
        var newCorpRec = Ext.create('EMIS.model.Corporate');
        me.getCorpForm().loadRecord(newCorpRec);
        me.getDelCorpButton().disable();
    },

    doDeleteCorporate: function(){
        var me = this;
        var rec = me.getCorpForm().getRecord();
        Ext.Msg.confirm('Confirm Delete Corporate', 'Are you sure you want to delete corporate ' +
            rec.get('corporateName') + '?', function(btn){
                if(btn ===  'yes'){
                    rec.destroy({
                        success: function(rec,operation){
                            Ext.Msg.alert('Delete success', operation.request.scope.reader.jsonData.msg);
                        },
                        failure: function(rec,operation){
                            Ext.Msg.alert('Delete failure', operation.request.scope.reader.jsonData.msg);
                        }
                    });
                }
        });
    },

    doSelectCorporate: function(grid, record){
        var me = this;
        me.getCorpForm().loadRecord(record);
        me.getCorpFormFieldset();
    },

    doSaveCorporate: function(){
        var me = this;
        var rec = me.getCorpForm().getRecord();
        if (rec !== null){
            me.getCorpForm().updateRecord();
            var errs = rec.validate();
            if(errs.isValid()){
                rec.save({
                    success: function(rec,operation){
                        if(typeof rec.store === 'undefined'){
                            me.getCorpList().getStore().add(rec);
                            me.getCorpList().getSelectionModel().select(rec,true);
                        }
                        me.getCorpFormFieldset().setTitle('Edit corporate' + rec.data.corporateName);
                        me.getDelCorpButton().enable();
                    },
                    failure: function(rec,operation){
                        Ext.Msg.alert('Save failed', operation.request.scope.reader.jsonData.msg);
                    }
                });
            } else {
                me.getCorpForm().getForm().markInvalid(errs);
                Ext.Msg.alert('Invalid Fields','Please fix the invalid entries');
            }
        }
    }


});
