Ext.define('EMIS.Application', {
    name: 'EMIS',
    extend: 'Ext.app.Application',
    requires: ['EMIS.view.LogonWindow'],
    models: ['User'],
    controllers: ['MainController',UserController],
    stores: ['User'],

    init: function(application){
        EMIS.URL_PREFIX='emis/';
        Ext.Ajax.on('beforerequest', function(conn,options,eOpts){
            options.url = EMIS.URL_PREFIX + options.url;
        });
    },

    launch: function(){
        var me = this;
        EMIS.console = function(output){
            if (typeof console !== 'undefined'){
                console.info(output);
            }
        };
        me.logonWindow = Ext.create('EMIS.view.LogonWindow');
        me.logonWindow.show();
    },

    doAfterLogon: function(userObj){
        EMIS.console(userObj);
        var me = this;
        me.getUser = function(){
            return userObj;
        }
        me.isAdmin = function(){
            return userObj.adminRole === 'Y';
        };
        Ext.create('EMIS.view.Viewport');
        me.logonWindow.hide();
    }

});
