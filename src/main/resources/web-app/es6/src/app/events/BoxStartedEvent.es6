'use strict';

class BoxStartedEvent extends AbstractBoxStartedEvent {
    prepareDataForView() {
        this.eventData = JSON.parse(JSON.stringify(this.eventParam));
    }
}

/*       S.D.G.       */
