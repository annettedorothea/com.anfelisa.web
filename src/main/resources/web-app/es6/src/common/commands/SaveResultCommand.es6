'use strict';

class SaveResultCommand extends AbstractSaveResultCommand {
    execute() {
        return new Promise((resolve) => {
            this.commandData.language = this.commandParam.language;
            if (this.commandParam.username == undefined) {
                this.commandData.points = this.commandParam.points;
                this.commandData.maxPoints = this.commandParam.maxPoints;
                this.commandData.outcome = this.noCredentials;
                resolve();
            } else {
                this.commandData.testId = this.commandParam.testId;
                this.httpPost("api/results/save", [], this.commandParam).then(() => {
                    this.commandData.outcome = this.resultSaved;
                    resolve();
                }, (error) => {
                    this.commandData.messageKey = "saveResultFailed";
                    this.commandData.error = error;
                    this.commandData.outcome = this.serverError;
                    resolve();
                });
            }
        });
    }
}

/*       S.D.G.       */