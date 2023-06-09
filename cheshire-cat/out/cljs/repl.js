// Compiled by ClojureScript 1.11.60 {:optimizations :none}
goog.provide('cljs.repl');
goog.require('cljs.core');
goog.require('cljs.spec.alpha');
goog.require('goog.string');
goog.require('goog.string.format');
cljs.repl.print_doc = (function cljs$repl$print_doc(p__4054){
var map__4055 = p__4054;
var map__4055__$1 = cljs.core.__destructure_map.call(null,map__4055);
var m = map__4055__$1;
var n = cljs.core.get.call(null,map__4055__$1,new cljs.core.Keyword(null,"ns","ns",441598760));
var nm = cljs.core.get.call(null,map__4055__$1,new cljs.core.Keyword(null,"name","name",1843675177));
cljs.core.println.call(null,"-------------------------");

cljs.core.println.call(null,(function (){var or__5045__auto__ = new cljs.core.Keyword(null,"spec","spec",347520401).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_(or__5045__auto__)){
return or__5045__auto__;
} else {
return [(function (){var temp__5720__auto__ = new cljs.core.Keyword(null,"ns","ns",441598760).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_(temp__5720__auto__)){
var ns = temp__5720__auto__;
return [cljs.core.str.cljs$core$IFn$_invoke$arity$1(ns),"/"].join('');
} else {
return null;
}
})(),cljs.core.str.cljs$core$IFn$_invoke$arity$1(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(m))].join('');
}
})());

if(cljs.core.truth_(new cljs.core.Keyword(null,"protocol","protocol",652470118).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Protocol");
} else {
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"forms","forms",2045992350).cljs$core$IFn$_invoke$arity$1(m))){
var seq__4056_4084 = cljs.core.seq.call(null,new cljs.core.Keyword(null,"forms","forms",2045992350).cljs$core$IFn$_invoke$arity$1(m));
var chunk__4057_4085 = null;
var count__4058_4086 = (0);
var i__4059_4087 = (0);
while(true){
if((i__4059_4087 < count__4058_4086)){
var f_4088 = cljs.core._nth.call(null,chunk__4057_4085,i__4059_4087);
cljs.core.println.call(null,"  ",f_4088);


var G__4089 = seq__4056_4084;
var G__4090 = chunk__4057_4085;
var G__4091 = count__4058_4086;
var G__4092 = (i__4059_4087 + (1));
seq__4056_4084 = G__4089;
chunk__4057_4085 = G__4090;
count__4058_4086 = G__4091;
i__4059_4087 = G__4092;
continue;
} else {
var temp__5720__auto___4093 = cljs.core.seq.call(null,seq__4056_4084);
if(temp__5720__auto___4093){
var seq__4056_4094__$1 = temp__5720__auto___4093;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__4056_4094__$1)){
var c__5568__auto___4095 = cljs.core.chunk_first.call(null,seq__4056_4094__$1);
var G__4096 = cljs.core.chunk_rest.call(null,seq__4056_4094__$1);
var G__4097 = c__5568__auto___4095;
var G__4098 = cljs.core.count.call(null,c__5568__auto___4095);
var G__4099 = (0);
seq__4056_4084 = G__4096;
chunk__4057_4085 = G__4097;
count__4058_4086 = G__4098;
i__4059_4087 = G__4099;
continue;
} else {
var f_4100 = cljs.core.first.call(null,seq__4056_4094__$1);
cljs.core.println.call(null,"  ",f_4100);


var G__4101 = cljs.core.next.call(null,seq__4056_4094__$1);
var G__4102 = null;
var G__4103 = (0);
var G__4104 = (0);
seq__4056_4084 = G__4101;
chunk__4057_4085 = G__4102;
count__4058_4086 = G__4103;
i__4059_4087 = G__4104;
continue;
}
} else {
}
}
break;
}
} else {
if(cljs.core.truth_(new cljs.core.Keyword(null,"arglists","arglists",1661989754).cljs$core$IFn$_invoke$arity$1(m))){
var arglists_4105 = new cljs.core.Keyword(null,"arglists","arglists",1661989754).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_((function (){var or__5045__auto__ = new cljs.core.Keyword(null,"macro","macro",-867863404).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_(or__5045__auto__)){
return or__5045__auto__;
} else {
return new cljs.core.Keyword(null,"repl-special-function","repl-special-function",1262603725).cljs$core$IFn$_invoke$arity$1(m);
}
})())){
cljs.core.prn.call(null,arglists_4105);
} else {
cljs.core.prn.call(null,((cljs.core._EQ_.call(null,new cljs.core.Symbol(null,"quote","quote",1377916282,null),cljs.core.first.call(null,arglists_4105)))?cljs.core.second.call(null,arglists_4105):arglists_4105));
}
} else {
}
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"special-form","special-form",-1326536374).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Special Form");

cljs.core.println.call(null," ",new cljs.core.Keyword(null,"doc","doc",1913296891).cljs$core$IFn$_invoke$arity$1(m));

if(cljs.core.contains_QMARK_.call(null,m,new cljs.core.Keyword(null,"url","url",276297046))){
if(cljs.core.truth_(new cljs.core.Keyword(null,"url","url",276297046).cljs$core$IFn$_invoke$arity$1(m))){
return cljs.core.println.call(null,["\n  Please see http://clojure.org/",cljs.core.str.cljs$core$IFn$_invoke$arity$1(new cljs.core.Keyword(null,"url","url",276297046).cljs$core$IFn$_invoke$arity$1(m))].join(''));
} else {
return null;
}
} else {
return cljs.core.println.call(null,["\n  Please see http://clojure.org/special_forms#",cljs.core.str.cljs$core$IFn$_invoke$arity$1(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(m))].join(''));
}
} else {
if(cljs.core.truth_(new cljs.core.Keyword(null,"macro","macro",-867863404).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Macro");
} else {
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"spec","spec",347520401).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Spec");
} else {
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"repl-special-function","repl-special-function",1262603725).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"REPL Special Function");
} else {
}

cljs.core.println.call(null," ",new cljs.core.Keyword(null,"doc","doc",1913296891).cljs$core$IFn$_invoke$arity$1(m));

if(cljs.core.truth_(new cljs.core.Keyword(null,"protocol","protocol",652470118).cljs$core$IFn$_invoke$arity$1(m))){
var seq__4060_4106 = cljs.core.seq.call(null,new cljs.core.Keyword(null,"methods","methods",453930866).cljs$core$IFn$_invoke$arity$1(m));
var chunk__4061_4107 = null;
var count__4062_4108 = (0);
var i__4063_4109 = (0);
while(true){
if((i__4063_4109 < count__4062_4108)){
var vec__4072_4110 = cljs.core._nth.call(null,chunk__4061_4107,i__4063_4109);
var name_4111 = cljs.core.nth.call(null,vec__4072_4110,(0),null);
var map__4075_4112 = cljs.core.nth.call(null,vec__4072_4110,(1),null);
var map__4075_4113__$1 = cljs.core.__destructure_map.call(null,map__4075_4112);
var doc_4114 = cljs.core.get.call(null,map__4075_4113__$1,new cljs.core.Keyword(null,"doc","doc",1913296891));
var arglists_4115 = cljs.core.get.call(null,map__4075_4113__$1,new cljs.core.Keyword(null,"arglists","arglists",1661989754));
cljs.core.println.call(null);

cljs.core.println.call(null," ",name_4111);

cljs.core.println.call(null," ",arglists_4115);

if(cljs.core.truth_(doc_4114)){
cljs.core.println.call(null," ",doc_4114);
} else {
}


var G__4116 = seq__4060_4106;
var G__4117 = chunk__4061_4107;
var G__4118 = count__4062_4108;
var G__4119 = (i__4063_4109 + (1));
seq__4060_4106 = G__4116;
chunk__4061_4107 = G__4117;
count__4062_4108 = G__4118;
i__4063_4109 = G__4119;
continue;
} else {
var temp__5720__auto___4120 = cljs.core.seq.call(null,seq__4060_4106);
if(temp__5720__auto___4120){
var seq__4060_4121__$1 = temp__5720__auto___4120;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__4060_4121__$1)){
var c__5568__auto___4122 = cljs.core.chunk_first.call(null,seq__4060_4121__$1);
var G__4123 = cljs.core.chunk_rest.call(null,seq__4060_4121__$1);
var G__4124 = c__5568__auto___4122;
var G__4125 = cljs.core.count.call(null,c__5568__auto___4122);
var G__4126 = (0);
seq__4060_4106 = G__4123;
chunk__4061_4107 = G__4124;
count__4062_4108 = G__4125;
i__4063_4109 = G__4126;
continue;
} else {
var vec__4076_4127 = cljs.core.first.call(null,seq__4060_4121__$1);
var name_4128 = cljs.core.nth.call(null,vec__4076_4127,(0),null);
var map__4079_4129 = cljs.core.nth.call(null,vec__4076_4127,(1),null);
var map__4079_4130__$1 = cljs.core.__destructure_map.call(null,map__4079_4129);
var doc_4131 = cljs.core.get.call(null,map__4079_4130__$1,new cljs.core.Keyword(null,"doc","doc",1913296891));
var arglists_4132 = cljs.core.get.call(null,map__4079_4130__$1,new cljs.core.Keyword(null,"arglists","arglists",1661989754));
cljs.core.println.call(null);

cljs.core.println.call(null," ",name_4128);

cljs.core.println.call(null," ",arglists_4132);

if(cljs.core.truth_(doc_4131)){
cljs.core.println.call(null," ",doc_4131);
} else {
}


var G__4133 = cljs.core.next.call(null,seq__4060_4121__$1);
var G__4134 = null;
var G__4135 = (0);
var G__4136 = (0);
seq__4060_4106 = G__4133;
chunk__4061_4107 = G__4134;
count__4062_4108 = G__4135;
i__4063_4109 = G__4136;
continue;
}
} else {
}
}
break;
}
} else {
}

if(cljs.core.truth_(n)){
var temp__5720__auto__ = cljs.spec.alpha.get_spec.call(null,cljs.core.symbol.call(null,cljs.core.str.cljs$core$IFn$_invoke$arity$1(cljs.core.ns_name.call(null,n)),cljs.core.name.call(null,nm)));
if(cljs.core.truth_(temp__5720__auto__)){
var fnspec = temp__5720__auto__;
cljs.core.print.call(null,"Spec");

var seq__4080 = cljs.core.seq.call(null,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"args","args",1315556576),new cljs.core.Keyword(null,"ret","ret",-468222814),new cljs.core.Keyword(null,"fn","fn",-1175266204)], null));
var chunk__4081 = null;
var count__4082 = (0);
var i__4083 = (0);
while(true){
if((i__4083 < count__4082)){
var role = cljs.core._nth.call(null,chunk__4081,i__4083);
var temp__5720__auto___4137__$1 = cljs.core.get.call(null,fnspec,role);
if(cljs.core.truth_(temp__5720__auto___4137__$1)){
var spec_4138 = temp__5720__auto___4137__$1;
cljs.core.print.call(null,["\n ",cljs.core.name.call(null,role),":"].join(''),cljs.spec.alpha.describe.call(null,spec_4138));
} else {
}


var G__4139 = seq__4080;
var G__4140 = chunk__4081;
var G__4141 = count__4082;
var G__4142 = (i__4083 + (1));
seq__4080 = G__4139;
chunk__4081 = G__4140;
count__4082 = G__4141;
i__4083 = G__4142;
continue;
} else {
var temp__5720__auto____$1 = cljs.core.seq.call(null,seq__4080);
if(temp__5720__auto____$1){
var seq__4080__$1 = temp__5720__auto____$1;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__4080__$1)){
var c__5568__auto__ = cljs.core.chunk_first.call(null,seq__4080__$1);
var G__4143 = cljs.core.chunk_rest.call(null,seq__4080__$1);
var G__4144 = c__5568__auto__;
var G__4145 = cljs.core.count.call(null,c__5568__auto__);
var G__4146 = (0);
seq__4080 = G__4143;
chunk__4081 = G__4144;
count__4082 = G__4145;
i__4083 = G__4146;
continue;
} else {
var role = cljs.core.first.call(null,seq__4080__$1);
var temp__5720__auto___4147__$2 = cljs.core.get.call(null,fnspec,role);
if(cljs.core.truth_(temp__5720__auto___4147__$2)){
var spec_4148 = temp__5720__auto___4147__$2;
cljs.core.print.call(null,["\n ",cljs.core.name.call(null,role),":"].join(''),cljs.spec.alpha.describe.call(null,spec_4148));
} else {
}


var G__4149 = cljs.core.next.call(null,seq__4080__$1);
var G__4150 = null;
var G__4151 = (0);
var G__4152 = (0);
seq__4080 = G__4149;
chunk__4081 = G__4150;
count__4082 = G__4151;
i__4083 = G__4152;
continue;
}
} else {
return null;
}
}
break;
}
} else {
return null;
}
} else {
return null;
}
}
});
/**
 * Constructs a data representation for a Error with keys:
 *  :cause - root cause message
 *  :phase - error phase
 *  :via - cause chain, with cause keys:
 *           :type - exception class symbol
 *           :message - exception message
 *           :data - ex-data
 *           :at - top stack element
 *  :trace - root cause stack elements
 */
cljs.repl.Error__GT_map = (function cljs$repl$Error__GT_map(o){
var base = (function (t){
return cljs.core.merge.call(null,new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"type","type",1174270348),(((t instanceof cljs.core.ExceptionInfo))?new cljs.core.Symbol("cljs.core","ExceptionInfo","cljs.core/ExceptionInfo",701839050,null):(((t instanceof Error))?cljs.core.symbol.call(null,"js",t.name):null
))], null),(function (){var temp__5720__auto__ = cljs.core.ex_message.call(null,t);
if(cljs.core.truth_(temp__5720__auto__)){
var msg = temp__5720__auto__;
return new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"message","message",-406056002),msg], null);
} else {
return null;
}
})(),(function (){var temp__5720__auto__ = cljs.core.ex_data.call(null,t);
if(cljs.core.truth_(temp__5720__auto__)){
var ed = temp__5720__auto__;
return new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"data","data",-232669377),ed], null);
} else {
return null;
}
})());
});
var via = (function (){var via = cljs.core.PersistentVector.EMPTY;
var t = o;
while(true){
if(cljs.core.truth_(t)){
var G__4153 = cljs.core.conj.call(null,via,t);
var G__4154 = cljs.core.ex_cause.call(null,t);
via = G__4153;
t = G__4154;
continue;
} else {
return via;
}
break;
}
})();
var root = cljs.core.peek.call(null,via);
return cljs.core.merge.call(null,new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"via","via",-1904457336),cljs.core.vec.call(null,cljs.core.map.call(null,base,via)),new cljs.core.Keyword(null,"trace","trace",-1082747415),null], null),(function (){var temp__5720__auto__ = cljs.core.ex_message.call(null,root);
if(cljs.core.truth_(temp__5720__auto__)){
var root_msg = temp__5720__auto__;
return new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"cause","cause",231901252),root_msg], null);
} else {
return null;
}
})(),(function (){var temp__5720__auto__ = cljs.core.ex_data.call(null,root);
if(cljs.core.truth_(temp__5720__auto__)){
var data = temp__5720__auto__;
return new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"data","data",-232669377),data], null);
} else {
return null;
}
})(),(function (){var temp__5720__auto__ = new cljs.core.Keyword("clojure.error","phase","clojure.error/phase",275140358).cljs$core$IFn$_invoke$arity$1(cljs.core.ex_data.call(null,o));
if(cljs.core.truth_(temp__5720__auto__)){
var phase = temp__5720__auto__;
return new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"phase","phase",575722892),phase], null);
} else {
return null;
}
})());
});
/**
 * Returns an analysis of the phase, error, cause, and location of an error that occurred
 *   based on Throwable data, as returned by Throwable->map. All attributes other than phase
 *   are optional:
 *  :clojure.error/phase - keyword phase indicator, one of:
 *    :read-source :compile-syntax-check :compilation :macro-syntax-check :macroexpansion
 *    :execution :read-eval-result :print-eval-result
 *  :clojure.error/source - file name (no path)
 *  :clojure.error/line - integer line number
 *  :clojure.error/column - integer column number
 *  :clojure.error/symbol - symbol being expanded/compiled/invoked
 *  :clojure.error/class - cause exception class symbol
 *  :clojure.error/cause - cause exception message
 *  :clojure.error/spec - explain-data for spec error
 */
cljs.repl.ex_triage = (function cljs$repl$ex_triage(datafied_throwable){
var map__4157 = datafied_throwable;
var map__4157__$1 = cljs.core.__destructure_map.call(null,map__4157);
var via = cljs.core.get.call(null,map__4157__$1,new cljs.core.Keyword(null,"via","via",-1904457336));
var trace = cljs.core.get.call(null,map__4157__$1,new cljs.core.Keyword(null,"trace","trace",-1082747415));
var phase = cljs.core.get.call(null,map__4157__$1,new cljs.core.Keyword(null,"phase","phase",575722892),new cljs.core.Keyword(null,"execution","execution",253283524));
var map__4158 = cljs.core.last.call(null,via);
var map__4158__$1 = cljs.core.__destructure_map.call(null,map__4158);
var type = cljs.core.get.call(null,map__4158__$1,new cljs.core.Keyword(null,"type","type",1174270348));
var message = cljs.core.get.call(null,map__4158__$1,new cljs.core.Keyword(null,"message","message",-406056002));
var data = cljs.core.get.call(null,map__4158__$1,new cljs.core.Keyword(null,"data","data",-232669377));
var map__4159 = data;
var map__4159__$1 = cljs.core.__destructure_map.call(null,map__4159);
var problems = cljs.core.get.call(null,map__4159__$1,new cljs.core.Keyword("cljs.spec.alpha","problems","cljs.spec.alpha/problems",447400814));
var fn = cljs.core.get.call(null,map__4159__$1,new cljs.core.Keyword("cljs.spec.alpha","fn","cljs.spec.alpha/fn",408600443));
var caller = cljs.core.get.call(null,map__4159__$1,new cljs.core.Keyword("cljs.spec.test.alpha","caller","cljs.spec.test.alpha/caller",-398302390));
var map__4160 = new cljs.core.Keyword(null,"data","data",-232669377).cljs$core$IFn$_invoke$arity$1(cljs.core.first.call(null,via));
var map__4160__$1 = cljs.core.__destructure_map.call(null,map__4160);
var top_data = map__4160__$1;
var source = cljs.core.get.call(null,map__4160__$1,new cljs.core.Keyword("clojure.error","source","clojure.error/source",-2011936397));
return cljs.core.assoc.call(null,(function (){var G__4161 = phase;
var G__4161__$1 = (((G__4161 instanceof cljs.core.Keyword))?G__4161.fqn:null);
switch (G__4161__$1) {
case "read-source":
var map__4162 = data;
var map__4162__$1 = cljs.core.__destructure_map.call(null,map__4162);
var line = cljs.core.get.call(null,map__4162__$1,new cljs.core.Keyword("clojure.error","line","clojure.error/line",-1816287471));
var column = cljs.core.get.call(null,map__4162__$1,new cljs.core.Keyword("clojure.error","column","clojure.error/column",304721553));
var G__4163 = cljs.core.merge.call(null,new cljs.core.Keyword(null,"data","data",-232669377).cljs$core$IFn$_invoke$arity$1(cljs.core.second.call(null,via)),top_data);
var G__4163__$1 = (cljs.core.truth_(source)?cljs.core.assoc.call(null,G__4163,new cljs.core.Keyword("clojure.error","source","clojure.error/source",-2011936397),source):G__4163);
var G__4163__$2 = (cljs.core.truth_(new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 2, ["NO_SOURCE_PATH",null,"NO_SOURCE_FILE",null], null), null).call(null,source))?cljs.core.dissoc.call(null,G__4163__$1,new cljs.core.Keyword("clojure.error","source","clojure.error/source",-2011936397)):G__4163__$1);
if(cljs.core.truth_(message)){
return cljs.core.assoc.call(null,G__4163__$2,new cljs.core.Keyword("clojure.error","cause","clojure.error/cause",-1879175742),message);
} else {
return G__4163__$2;
}

break;
case "compile-syntax-check":
case "compilation":
case "macro-syntax-check":
case "macroexpansion":
var G__4164 = top_data;
var G__4164__$1 = (cljs.core.truth_(source)?cljs.core.assoc.call(null,G__4164,new cljs.core.Keyword("clojure.error","source","clojure.error/source",-2011936397),source):G__4164);
var G__4164__$2 = (cljs.core.truth_(new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 2, ["NO_SOURCE_PATH",null,"NO_SOURCE_FILE",null], null), null).call(null,source))?cljs.core.dissoc.call(null,G__4164__$1,new cljs.core.Keyword("clojure.error","source","clojure.error/source",-2011936397)):G__4164__$1);
var G__4164__$3 = (cljs.core.truth_(type)?cljs.core.assoc.call(null,G__4164__$2,new cljs.core.Keyword("clojure.error","class","clojure.error/class",278435890),type):G__4164__$2);
var G__4164__$4 = (cljs.core.truth_(message)?cljs.core.assoc.call(null,G__4164__$3,new cljs.core.Keyword("clojure.error","cause","clojure.error/cause",-1879175742),message):G__4164__$3);
if(cljs.core.truth_(problems)){
return cljs.core.assoc.call(null,G__4164__$4,new cljs.core.Keyword("clojure.error","spec","clojure.error/spec",2055032595),data);
} else {
return G__4164__$4;
}

break;
case "read-eval-result":
case "print-eval-result":
var vec__4165 = cljs.core.first.call(null,trace);
var source__$1 = cljs.core.nth.call(null,vec__4165,(0),null);
var method = cljs.core.nth.call(null,vec__4165,(1),null);
var file = cljs.core.nth.call(null,vec__4165,(2),null);
var line = cljs.core.nth.call(null,vec__4165,(3),null);
var G__4168 = top_data;
var G__4168__$1 = (cljs.core.truth_(line)?cljs.core.assoc.call(null,G__4168,new cljs.core.Keyword("clojure.error","line","clojure.error/line",-1816287471),line):G__4168);
var G__4168__$2 = (cljs.core.truth_(file)?cljs.core.assoc.call(null,G__4168__$1,new cljs.core.Keyword("clojure.error","source","clojure.error/source",-2011936397),file):G__4168__$1);
var G__4168__$3 = (cljs.core.truth_((function (){var and__5043__auto__ = source__$1;
if(cljs.core.truth_(and__5043__auto__)){
return method;
} else {
return and__5043__auto__;
}
})())?cljs.core.assoc.call(null,G__4168__$2,new cljs.core.Keyword("clojure.error","symbol","clojure.error/symbol",1544821994),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[source__$1,method],null))):G__4168__$2);
var G__4168__$4 = (cljs.core.truth_(type)?cljs.core.assoc.call(null,G__4168__$3,new cljs.core.Keyword("clojure.error","class","clojure.error/class",278435890),type):G__4168__$3);
if(cljs.core.truth_(message)){
return cljs.core.assoc.call(null,G__4168__$4,new cljs.core.Keyword("clojure.error","cause","clojure.error/cause",-1879175742),message);
} else {
return G__4168__$4;
}

break;
case "execution":
var vec__4169 = cljs.core.first.call(null,trace);
var source__$1 = cljs.core.nth.call(null,vec__4169,(0),null);
var method = cljs.core.nth.call(null,vec__4169,(1),null);
var file = cljs.core.nth.call(null,vec__4169,(2),null);
var line = cljs.core.nth.call(null,vec__4169,(3),null);
var file__$1 = cljs.core.first.call(null,cljs.core.remove.call(null,(function (p1__4156_SHARP_){
var or__5045__auto__ = (p1__4156_SHARP_ == null);
if(or__5045__auto__){
return or__5045__auto__;
} else {
return new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 2, ["NO_SOURCE_PATH",null,"NO_SOURCE_FILE",null], null), null).call(null,p1__4156_SHARP_);
}
}),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"file","file",-1269645878).cljs$core$IFn$_invoke$arity$1(caller),file], null)));
var err_line = (function (){var or__5045__auto__ = new cljs.core.Keyword(null,"line","line",212345235).cljs$core$IFn$_invoke$arity$1(caller);
if(cljs.core.truth_(or__5045__auto__)){
return or__5045__auto__;
} else {
return line;
}
})();
var G__4172 = new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword("clojure.error","class","clojure.error/class",278435890),type], null);
var G__4172__$1 = (cljs.core.truth_(err_line)?cljs.core.assoc.call(null,G__4172,new cljs.core.Keyword("clojure.error","line","clojure.error/line",-1816287471),err_line):G__4172);
var G__4172__$2 = (cljs.core.truth_(message)?cljs.core.assoc.call(null,G__4172__$1,new cljs.core.Keyword("clojure.error","cause","clojure.error/cause",-1879175742),message):G__4172__$1);
var G__4172__$3 = (cljs.core.truth_((function (){var or__5045__auto__ = fn;
if(cljs.core.truth_(or__5045__auto__)){
return or__5045__auto__;
} else {
var and__5043__auto__ = source__$1;
if(cljs.core.truth_(and__5043__auto__)){
return method;
} else {
return and__5043__auto__;
}
}
})())?cljs.core.assoc.call(null,G__4172__$2,new cljs.core.Keyword("clojure.error","symbol","clojure.error/symbol",1544821994),(function (){var or__5045__auto__ = fn;
if(cljs.core.truth_(or__5045__auto__)){
return or__5045__auto__;
} else {
return (new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[source__$1,method],null));
}
})()):G__4172__$2);
var G__4172__$4 = (cljs.core.truth_(file__$1)?cljs.core.assoc.call(null,G__4172__$3,new cljs.core.Keyword("clojure.error","source","clojure.error/source",-2011936397),file__$1):G__4172__$3);
if(cljs.core.truth_(problems)){
return cljs.core.assoc.call(null,G__4172__$4,new cljs.core.Keyword("clojure.error","spec","clojure.error/spec",2055032595),data);
} else {
return G__4172__$4;
}

break;
default:
throw (new Error(["No matching clause: ",cljs.core.str.cljs$core$IFn$_invoke$arity$1(G__4161__$1)].join('')));

}
})(),new cljs.core.Keyword("clojure.error","phase","clojure.error/phase",275140358),phase);
});
/**
 * Returns a string from exception data, as produced by ex-triage.
 *   The first line summarizes the exception phase and location.
 *   The subsequent lines describe the cause.
 */
cljs.repl.ex_str = (function cljs$repl$ex_str(p__4176){
var map__4177 = p__4176;
var map__4177__$1 = cljs.core.__destructure_map.call(null,map__4177);
var triage_data = map__4177__$1;
var phase = cljs.core.get.call(null,map__4177__$1,new cljs.core.Keyword("clojure.error","phase","clojure.error/phase",275140358));
var source = cljs.core.get.call(null,map__4177__$1,new cljs.core.Keyword("clojure.error","source","clojure.error/source",-2011936397));
var line = cljs.core.get.call(null,map__4177__$1,new cljs.core.Keyword("clojure.error","line","clojure.error/line",-1816287471));
var column = cljs.core.get.call(null,map__4177__$1,new cljs.core.Keyword("clojure.error","column","clojure.error/column",304721553));
var symbol = cljs.core.get.call(null,map__4177__$1,new cljs.core.Keyword("clojure.error","symbol","clojure.error/symbol",1544821994));
var class$ = cljs.core.get.call(null,map__4177__$1,new cljs.core.Keyword("clojure.error","class","clojure.error/class",278435890));
var cause = cljs.core.get.call(null,map__4177__$1,new cljs.core.Keyword("clojure.error","cause","clojure.error/cause",-1879175742));
var spec = cljs.core.get.call(null,map__4177__$1,new cljs.core.Keyword("clojure.error","spec","clojure.error/spec",2055032595));
var loc = [cljs.core.str.cljs$core$IFn$_invoke$arity$1((function (){var or__5045__auto__ = source;
if(cljs.core.truth_(or__5045__auto__)){
return or__5045__auto__;
} else {
return "<cljs repl>";
}
})()),":",cljs.core.str.cljs$core$IFn$_invoke$arity$1((function (){var or__5045__auto__ = line;
if(cljs.core.truth_(or__5045__auto__)){
return or__5045__auto__;
} else {
return (1);
}
})()),(cljs.core.truth_(column)?[":",cljs.core.str.cljs$core$IFn$_invoke$arity$1(column)].join(''):"")].join('');
var class_name = cljs.core.name.call(null,(function (){var or__5045__auto__ = class$;
if(cljs.core.truth_(or__5045__auto__)){
return or__5045__auto__;
} else {
return "";
}
})());
var simple_class = class_name;
var cause_type = ((cljs.core.contains_QMARK_.call(null,new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 2, ["RuntimeException",null,"Exception",null], null), null),simple_class))?"":[" (",simple_class,")"].join(''));
var format = goog.string.format;
var G__4178 = phase;
var G__4178__$1 = (((G__4178 instanceof cljs.core.Keyword))?G__4178.fqn:null);
switch (G__4178__$1) {
case "read-source":
return format.call(null,"Syntax error reading source at (%s).\n%s\n",loc,cause);

break;
case "macro-syntax-check":
return format.call(null,"Syntax error macroexpanding %sat (%s).\n%s",(cljs.core.truth_(symbol)?[cljs.core.str.cljs$core$IFn$_invoke$arity$1(symbol)," "].join(''):""),loc,(cljs.core.truth_(spec)?(function (){var sb__5690__auto__ = (new goog.string.StringBuffer());
var _STAR_print_newline_STAR__orig_val__4179_4188 = cljs.core._STAR_print_newline_STAR_;
var _STAR_print_fn_STAR__orig_val__4180_4189 = cljs.core._STAR_print_fn_STAR_;
var _STAR_print_newline_STAR__temp_val__4181_4190 = true;
var _STAR_print_fn_STAR__temp_val__4182_4191 = (function (x__5691__auto__){
return sb__5690__auto__.append(x__5691__auto__);
});
(cljs.core._STAR_print_newline_STAR_ = _STAR_print_newline_STAR__temp_val__4181_4190);

(cljs.core._STAR_print_fn_STAR_ = _STAR_print_fn_STAR__temp_val__4182_4191);

try{cljs.spec.alpha.explain_out.call(null,cljs.core.update.call(null,spec,new cljs.core.Keyword("cljs.spec.alpha","problems","cljs.spec.alpha/problems",447400814),(function (probs){
return cljs.core.map.call(null,(function (p1__4174_SHARP_){
return cljs.core.dissoc.call(null,p1__4174_SHARP_,new cljs.core.Keyword(null,"in","in",-1531184865));
}),probs);
}))
);
}finally {(cljs.core._STAR_print_fn_STAR_ = _STAR_print_fn_STAR__orig_val__4180_4189);

(cljs.core._STAR_print_newline_STAR_ = _STAR_print_newline_STAR__orig_val__4179_4188);
}
return cljs.core.str.cljs$core$IFn$_invoke$arity$1(sb__5690__auto__);
})():format.call(null,"%s\n",cause)));

break;
case "macroexpansion":
return format.call(null,"Unexpected error%s macroexpanding %sat (%s).\n%s\n",cause_type,(cljs.core.truth_(symbol)?[cljs.core.str.cljs$core$IFn$_invoke$arity$1(symbol)," "].join(''):""),loc,cause);

break;
case "compile-syntax-check":
return format.call(null,"Syntax error%s compiling %sat (%s).\n%s\n",cause_type,(cljs.core.truth_(symbol)?[cljs.core.str.cljs$core$IFn$_invoke$arity$1(symbol)," "].join(''):""),loc,cause);

break;
case "compilation":
return format.call(null,"Unexpected error%s compiling %sat (%s).\n%s\n",cause_type,(cljs.core.truth_(symbol)?[cljs.core.str.cljs$core$IFn$_invoke$arity$1(symbol)," "].join(''):""),loc,cause);

break;
case "read-eval-result":
return format.call(null,"Error reading eval result%s at %s (%s).\n%s\n",cause_type,symbol,loc,cause);

break;
case "print-eval-result":
return format.call(null,"Error printing return value%s at %s (%s).\n%s\n",cause_type,symbol,loc,cause);

break;
case "execution":
if(cljs.core.truth_(spec)){
return format.call(null,"Execution error - invalid arguments to %s at (%s).\n%s",symbol,loc,(function (){var sb__5690__auto__ = (new goog.string.StringBuffer());
var _STAR_print_newline_STAR__orig_val__4183_4192 = cljs.core._STAR_print_newline_STAR_;
var _STAR_print_fn_STAR__orig_val__4184_4193 = cljs.core._STAR_print_fn_STAR_;
var _STAR_print_newline_STAR__temp_val__4185_4194 = true;
var _STAR_print_fn_STAR__temp_val__4186_4195 = (function (x__5691__auto__){
return sb__5690__auto__.append(x__5691__auto__);
});
(cljs.core._STAR_print_newline_STAR_ = _STAR_print_newline_STAR__temp_val__4185_4194);

(cljs.core._STAR_print_fn_STAR_ = _STAR_print_fn_STAR__temp_val__4186_4195);

try{cljs.spec.alpha.explain_out.call(null,cljs.core.update.call(null,spec,new cljs.core.Keyword("cljs.spec.alpha","problems","cljs.spec.alpha/problems",447400814),(function (probs){
return cljs.core.map.call(null,(function (p1__4175_SHARP_){
return cljs.core.dissoc.call(null,p1__4175_SHARP_,new cljs.core.Keyword(null,"in","in",-1531184865));
}),probs);
}))
);
}finally {(cljs.core._STAR_print_fn_STAR_ = _STAR_print_fn_STAR__orig_val__4184_4193);

(cljs.core._STAR_print_newline_STAR_ = _STAR_print_newline_STAR__orig_val__4183_4192);
}
return cljs.core.str.cljs$core$IFn$_invoke$arity$1(sb__5690__auto__);
})());
} else {
return format.call(null,"Execution error%s at %s(%s).\n%s\n",cause_type,(cljs.core.truth_(symbol)?[cljs.core.str.cljs$core$IFn$_invoke$arity$1(symbol)," "].join(''):""),loc,cause);
}

break;
default:
throw (new Error(["No matching clause: ",cljs.core.str.cljs$core$IFn$_invoke$arity$1(G__4178__$1)].join('')));

}
});
cljs.repl.error__GT_str = (function cljs$repl$error__GT_str(error){
return cljs.repl.ex_str.call(null,cljs.repl.ex_triage.call(null,cljs.repl.Error__GT_map.call(null,error)));
});

//# sourceMappingURL=repl.js.map
