export default class AlunosController {

    constructor(AlunoService) {
        this.filter = '';
        this.records = [];
        this._service = AlunoService;
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

AlunosController.$inject = ['AlunoService'];