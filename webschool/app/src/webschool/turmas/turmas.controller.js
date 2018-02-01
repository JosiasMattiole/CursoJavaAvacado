export default class TurmasController {
    
    constructor(TurmaService) {
        this.filter = '';
        this.records = [];
        this._service = TurmaService;
        this.load();
    };
    
    load() {
        this._service.findAll()
            .then(data => {
                this.records = data;
            })
            .catch(error => {
                console.log(error);
            });
    };
    
    excluir(id) {
        this._service.remove(id)
            .then(response => {
                this.load();
            })
    };
};
    
TurmasController.$inject = ['TurmaService'];