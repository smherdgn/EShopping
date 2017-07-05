var kurum = "SIRKETESENLER";
var __ExtentBuffer = 1000;
var __DefaultZoom = 3;
var __MinZoom = 3;
var __MaxZoom = 16;


if (kurum == "SIRKETESENLER") {
    var __projection = 'EPSG:5254';
    var __ipadress = '10.0.1.39';
    var __port = 8443;
    var __username = 'admin';
    var __password = 'geoserver';
    var __defaultWorkspace = 'cite';
    var __workspace = 'cite';
    var __location1 = 'ISTANBUL';
    var __protokol = 'HTTPS';
    var __layers = [
        {
            name: 'default',
            isLayerGroup: true,
            isBaseLayer: false,
            seperateLayers: false,
            visibility: false,
            layerGroupOptions: {workspace: __workspace},
            zIndex: 1,
            displayInLayerSwitcher: false
        }
    ];
    var FeatureMappings = [
        {
            FeatureType: "ILCE",
            LayerName: "ILCE",
            KeyField: "kimlikno",
            ValueField: "ad"
        },
        {
            FeatureType: "MAHALLE",
            LayerName: "mahalle",
            KeyField: "nc_oid",
            ValueField: "ad",
            IlceField: "ilcekn",
        },
        {
            FeatureType: "YOL",
            LayerName: "yollar",
            KeyField: "uavtkodu",
            ValueField: "yol",
            YolTuruField: "turu",
            MahalleKeyField: "mahallegid",
            MahalleValueField: "mahallegid",
            IlceKeyField: "ilcegid",
            IlceValueField: "ilcegid",
        },
        {
            FeatureType: "KAPI",
            LayerName: "kapi",
            KeyField: "nc_oid",
            ValueField: "kapi",
            YolField: "yoluavt",
            AdaField: "ada",
            ParselField: "parsel"
        }
    ];
}

if (kurum == "ANKARA_AYKOME") {
    var __projection = 'EPSG:900913';
    var __ipadress = 'baskentaykome.ankara.bel.tr';
    var __port = 8444;
    var __username = 'geoUser';
    var __password = 'geoUser06';
    var __defaultWorkspace = 'cite';
    var __workspace = 'cite';
    var __location1 = 'Ankara';
    var __protokol = 'HTTPS';
    FeatureMappings = [
        {
            FeatureType: "ILCE",
            LayerName: "uavt_ilce",
            KeyField: "uavtkod",
            ValueField: "ad"
        },
        {
            FeatureType: "MAHALLE",
            LayerName: "uavt_mahalle_tum",
            KeyField: "uavtkod",
            ValueField: "ad",
            IlceField: "ilceuavtkod",
        },
        {
            FeatureType: "YOL",
            LayerName: "uavt_csbm_tum",
            KeyField: "uavtkod",
            ValueField: "ad",
            YolTuruField: "yoltip",
            MahalleKeyField: "mahalleuavtkod",
            MahalleValueField: "mahalleuavtad",
            IlceKeyField: "ilceuavtkod",
            IlceValueField: "ilceuavtad",
        },
        {
            FeatureType: "KAPI",
            LayerName: "uavt_bina",
            KeyField: "uavtkod",
            ValueField: "diskapino",
            YolField: "csbmkodu"
        }
    ];
}

if (kurum == "ANKARA_RDM") {
    var __projection = 'EPSG:900913';
    var __ipadress = 'ruhsatdenetim.ankara.bel.tr';
    var __port = 8444;
    var __username = 'geoUser';
    var __password = 'geoUser06';
    var __defaultWorkspace = 'cite';
    var __workspace = 'cite';
    var __location1 = 'Ankara';
    var __protokol = 'HTTPS';
    FeatureMappings = [
        {
            FeatureType: "ILCE",
            LayerName: "uavt_ilce",
            KeyField: "uavtkod",
            ValueField: "ad"
        },
        {
            FeatureType: "MAHALLE",
            LayerName: "uavt_mahalle_tum",
            KeyField: "uavtkod",
            ValueField: "ad",
            IlceField: "ilceuavtkod",
        },
        {
            FeatureType: "YOL",
            LayerName: "uavt_csbm_tum",
            KeyField: "uavtkod",
            ValueField: "ad",
            YolTuruField: "yoltip",
            MahalleKeyField: "mahalleuavtkod",
            MahalleValueField: "mahalleuavtad",
            IlceKeyField: "ilceuavtkod",
            IlceValueField: "ilceuavtad",
        },
        {
            FeatureType: "KAPI",
            LayerName: "uavt_bina",
            KeyField: "uavtkod",
            ValueField: "diskapino",
            YolField: "csbmkodu"
        }
    ];
}
if (kurum == "SIRKETANKARA") {
    var __projection = 'EPSG:900913';
    var __ipadress = '10.0.1.39';
    var __port = 8443;
    var __username = 'admin';
    var __password = 'geoserver';
    var __defaultWorkspace = 'aykome';
    var __workspace = 'aykome';
    var __location1 = 'Ankara';
    var __protokol = 'HTTPS';

    FeatureMappings = [
        {
            FeatureType: "ILCE",
            LayerName: "uavt_ilce",
            KeyField: "uavtkod",
            ValueField: "ad"
        },
        {
            FeatureType: "MAHALLE",
            LayerName: "uavt_mahalle",
            KeyField: "uavtkod",
            ValueField: "ad",
            IlceField: "ilceuavtkod",
        },
        {
            FeatureType: "YOL",
            LayerName: "uavt_csbm_tum",
            KeyField: "uavtkod",
            ValueField: "ad",
            YolTuruField: "yoltip",
            MahalleKeyField: "mahalleuavtkod",
            MahalleValueField: "mahalleuavtad",
            IlceKeyField: "ilceuavtkod",
            IlceValueField: "ilceuavtad",
        },
        {
            FeatureType: "KAPI",
            LayerName: "uavt_bina",
            KeyField: "uavtkod",
            ValueField: "diskapino",
            YolField: "csbmkodu"
        }
    ];

    var __layers = [
        {
            name: 'default',
            isLayerGroup: true,
            isBaseLayer: true,
            seperateLayers: true,
            layerGroupOptions: {workspace: __workspace},
            zIndex: 1
        }
    ];
}

if (kurum == "SIRKET_ANKARA_RDM") {
    var __projection = 'EPSG:900913';
    var __ipadress = '10.0.1.39';
    var __port = 8443;
    var __username = 'admin';
    var __password = 'geoserver';
    var __defaultWorkspace = 'aykome';
    var __workspace = 'aykome';
    var __location1 = 'Ankara';
    var __protokol = 'HTTPS';
    FeatureMappings = [
        {
            FeatureType: "ILCE",
            LayerName: "uavt_ilce",
            KeyField: "uavtkod",
            ValueField: "ad"
        },
        {
            FeatureType: "MAHALLE",
            LayerName: "uavt_mahalle",
            KeyField: "uavtkod",
            ValueField: "ad",
            IlceField: "ilceuavtkod",
        },
        {
            FeatureType: "YOL",
            LayerName: "uavt_csbm_tum",
            KeyField: "uavtkod",
            ValueField: "ad",
            YolTuruField: "yoltip",
            MahalleKeyField: "mahalleuavtkod",
            MahalleValueField: "mahalleuavtad",
            IlceKeyField: "ilceuavtkod",
            IlceValueField: "ilceuavtad",
        },
        {
            FeatureType: "KAPI",
            LayerName: "uavt_bina",
            KeyField: "uavtkod",
            ValueField: "diskapino",
            YolField: "csbmkodu",
            AdaField: "ada",
            ParselField: "parsel"
        }
    ];
    var __layers = [
        {
            name: 'default',
            isLayerGroup: true,
            isBaseLayer: true,
            seperateLayers: true,
            layerGroupOptions: {workspace: __workspace},
            zIndex: 1
        }
    ];
}
if (kurum == "ESENLER") {
    var __projection = 'EPSG:900913';
    var __ipadress = 'rasis.esenler.bel.tr';
    var __port = 8443;
    var __username = 'geoUser';
    var __password = 'geoUser34';
    var __defaultWorkspace = 'cite';
    var __workspace = 'cite';
    var __location1 = 'ISTANBUL';
    var __protokol = 'HTTPS';
    __layers = [
        {
            name: 'default',
            isLayerGroup: true,
            isBaseLayer: false,
            seperateLayers: false,
            visibility: false,
            layerGroupOptions: {workspace: __workspace},
            zIndex: 1,
            displayInLayerSwitcher: true
        }
    ];
    FeatureMappings = [
        {
            FeatureType: "ILCE",
            LayerName: "ILCE",
            KeyField: "kimlikno",
            ValueField: "ad"
        },
        {
            FeatureType: "MAHALLE",
            LayerName: "mis_mahalle",
            KeyField: "mahalle_kod",
            ValueField: "mahalle_ad",
            IlceField: "mahalle_koykod",
        },
        {
            FeatureType: "YOL",
            LayerName: "mis_sokak",
            KeyField: "sokak_kod",
            ValueField: "sokak_ad",
            YolTuruField: "sokak_tipi",
            MahalleKeyField: "sokak_mahallekod",
            MahalleValueField: "sokak_mahallead",
        },
        {
            FeatureType: "KAPI",
            LayerName: "mis_kapi",
            KeyField: "kapi_id",
            ValueField: "kapi_diskapino",
            YolField: "kapi_csbmkodu"
        }
    ];
}